
SET @id = (SELECT ToyID FROM Toys WHERE ToyName = 'Basketball');

SELECT 
(SELECT Name FROM Shops WHERE ShopNum = (SELECT ShopNum FROM Toys WHERE ToyID = @id)),
(SELECT Address FROM Shops WHERE ShopNum = (SELECT ShopNum FROM Toys WHERE ToyID = @id)),
(SELECT Stock FROM Stock WHERE ToyID = @id) 
FROM Stock, Shops
ORDER BY Stock DESC, Shops.Name, Shops.Address;
