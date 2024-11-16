# OnionCurrency

## 1. Command

- /oc add {name}
  - 添加货币 {name}
  - 权限：onioncurrency.add
- /oc remove {name}
  - 删除货币 {name}
  - 权限：onioncurrency.remove
- /oc set {player} {name} {count}
  - 设置玩家{player}的货币{name}数量{count}
  - 权限：onioncurrency.set
- /oc give {player} {name} {count}
  - 当前玩家给予另一玩家{player} 数量{count}的货币{name}
  - 权限：onioncurrency.give
- /oc give {player_1} {player_2} {name} {count}
  - 将玩家{player_1}的数量{count}的货币{name}转给玩家{player_2}
  - 权限： onioncurrency.give.to
- /oc list
  - 查看所有货币
  - 权限：onioncurrency.list
- /oc info {name}
  - 查看货币{name}的信息