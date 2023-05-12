
SELECT ToyName, Price FROM Toys WHERE ToyID IN 
(SELECT ToyID FROM Toys WHERE ToyID IN (SELECT ToyID FROM Stock WHERE ShopNum = (SELECT ShopNum FROM Shops WHERE Name = "Cinemall")) AND Price < 40) 
ORDER BY Price ASC;
