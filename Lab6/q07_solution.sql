
SELECT Sum(Stock) FROM Stock WHERE ToyID = (SELECT ToyID FROM Toys WHERE ToyName = 'Toy Truck');