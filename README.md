# OnionCurrency

## 1. Command

- /oc new {name}
  - 添加货币 {name}
  - 权限：onion.currency.new
- /oc remove {name}
  - 删除货币 {name}
  - 权限：onion.currency.remove
- /oc set {player} {name} {count}
  - 设置玩家{player}的货币{name}数量{count}
  - 权限：onion.currency.set
- /oc add {player} {name} {count}
  - 新增玩家{player}的货币{name}数量{count}
  - 权限：onion.currency.add
- /oc give {player} {name} {count}
  - 当前玩家给予另一玩家{player} 数量{count}的货币{name}
  - 权限：onion.currency.give
- /oc give {player_1} {player_2} {name} {count}
  - 将玩家{player_1}的数量{count}的货币{name}转给玩家{player_2}
  - 权限： onion.currency.give.to