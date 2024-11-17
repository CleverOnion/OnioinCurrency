package com.cleveronion.onionCurrency.handler;

import com.cleveronion.onionCurrency.OnionCurrency;
import com.cleveronion.onionCurrency.model.Currency;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CurrencyHandler {

    // 根据配置文件判断是否已经存在该货币
    public static boolean isCurrencyExist(String id) {
        Set<String> keys = OnionCurrency.config.getConfigurationSection("currencies").getKeys(false);
        for (String key : keys) {
            if (key.equals(id)) {
                return true;
            }
        }
        return false;
    }

    // 添加货币到配置文件并创建对应目录
    public static void addCurrency(Currency currency) {
        OnionCurrency.config.set("currencies." + currency.getId() + ".name", currency.getName());
        OnionCurrency.config.set("currencies." + currency.getId() + ".description", currency.getDescription());
        OnionCurrency.instance.saveConfig();//
        // 创建对应目录
        ((OnionCurrency) (OnionCurrency.instance)).loadCurrenciesData();
    }

    // 删除货币
    public static void removeCurrency(String id) {
        OnionCurrency.config.set("currencies." + id, null);
        OnionCurrency.instance.saveConfig();

        // 删除对应目录
        File currencyFolder = new File(OnionCurrency.instance.getDataFolder(), "currencies/" + id);
        if (currencyFolder.exists()) {
            currencyFolder.delete();
        }
    }

    // 查看具体货币
    public static Currency getCurrency(String id) {
        return Currency.builder()
                .id(id)
                .name(OnionCurrency.config.getString("currencies." + id + ".name"))
                .description(OnionCurrency.config.getString("currencies." + id + ".description"))
                .build();
    }

    // 获取所有货币
    public static ArrayList<Currency> getCurrencies() {
        ArrayList<Currency> currencies = new ArrayList<>();
        Set<String> keys = OnionCurrency.config.getConfigurationSection("currencies").getKeys(false);
        for (String key : keys) {
            currencies.add(getCurrency(key));
        }
        return currencies;
    }

    // 为指定玩家添加指定货币数量
    public static void addCurrencyToPlayer(String playerName, String currencyId, int amount) {
        File currencyFolder = new File(OnionCurrency.instance.getDataFolder(), "currencies");
        if (!currencyFolder.exists()) {
            currencyFolder.mkdirs();
        }

        File currencyFile = new File(currencyFolder, currencyId + ".yml");

        // 读取现有的 YAML 文件内容
        Map<String, Object> data = new HashMap<>();
        try (FileReader reader = new FileReader(currencyFile)) {
            Yaml yaml = new Yaml();
            data = yaml.load(reader);
            if (data == null) {
                data = new HashMap<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 更新或添加新的 key-value 对
        // 如果原本没有这个key-value，则直接设置；如果原本有这个k-v，则在原来的基础上加上amount
        data.put(playerName, data.containsKey(playerName) ? (int) data.get(playerName) + amount : amount);

        // 将更新后的内容写回 YAML 文件
        try (FileWriter writer = new FileWriter(currencyFile)) {
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml yaml = new Yaml(options);
            yaml.dump(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setCurrencyToPlayer(String playerName, String currencyId, int amount) {
        File currencyFolder = new File(OnionCurrency.instance.getDataFolder(), "currencies");
        if (!currencyFolder.exists()) {
            currencyFolder.mkdirs();
        }

        File currencyFile = new File(currencyFolder, currencyId + ".yml");

        // 读取现有的 YAML 文件内容
        Map<String, Object> data = new HashMap<>();
        try (FileReader reader = new FileReader(currencyFile)) {
            Yaml yaml = new Yaml();
            data = yaml.load(reader);
            if (data == null) {
                data = new HashMap<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 更新或添加新的 key-value 对
        // 如果原本没有这个key-value，则直接设置；如果原本有这个k-v，则在原来的基础上加上amount
        data.put(playerName, amount);

        // 将更新后的内容写回 YAML 文件
        try (FileWriter writer = new FileWriter(currencyFile)) {
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            Yaml yaml = new Yaml(options);
            yaml.dump(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取指定玩家指定货币数量
    public static int getCurrencyAmount(String playerName, String currencyId) {
        File currencyYml = new File(OnionCurrency.instance.getDataFolder(), "currencies/" + currencyId + ".yml");

        Map<String, Object> data = new HashMap<>();
        if (currencyYml.exists()) {
            try (FileReader reader = new FileReader(currencyYml)) {
                Yaml yaml = new Yaml();
                data = yaml.load(reader);
                if (data == null) {
                    data = new HashMap<>();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (Integer) data.get(playerName) == null ? 0 : (Integer) data.get(playerName);
    }
}
