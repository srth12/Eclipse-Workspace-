select f.name, fc.year, fc.month, count(ft.transactionid), count(ft.quantity), sum(ft.quantity * ft.totalamountpaid)
from Fruits f join FruitCosts fc on f.id = fc.fruitid
left join FruitTransactions ft on f.id = ft.fruitid and fc.year = ft.year and fc.month = ft.month
where  fc.cost > ft.totalamountpaid
group by f.id, fc.year, fc.month
having count(ft.transactionid) >= 5
