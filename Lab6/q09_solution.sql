
SELECT COUNT(ShopNum) FROM Stock WHERE ToyID = (SELECT ToyID FROM Toys WHERE ToyName = 'Barbie doll');