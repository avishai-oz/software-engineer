
SELECT Shops.Name, Shops.Address, Stock.Stock
FROM Shops
JOIN Stock ON Shops.ShopNum = Stock.ShopNum
WHERE Stock.ToyID = (SELECT ToyID FROM Toys WHERE ToyName = 'Basketball')
ORDER BY Stock DESC;
