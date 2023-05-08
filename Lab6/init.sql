
CREATE TABLE Shops (
    ShopNum INT,
    Name VARCHAR(10),
    City VARCHAR(20),
    Address VARCHAR(40),
    Manager VARCHAR(20),
    TodayRevenue INT
);

CREATE TABLE Toys (
    ToyID INT,
    ToyName VARCHAR(20),
    Price INT
);

CREATE TABLE Stock (
    ShopNum INT,
    ToyID INT,
    Stock INT
);

INSERT INTO Shops VALUES (1, 'Azrieli', 'Tel-Aviv', 'Derech Menachem Begin 132', 'Netta Cohen', 12015);
INSERT INTO Shops VALUES (2, 'Malha', 'Jerusalem', 'Agudat HaSport Beitar 1', 'Daniel Shitrit', 9540);
INSERT INTO Shops VALUES (3, 'Cinemall', 'Haifa', 'HaHistadrut Ave 55', 'Amit Ben-David', 6520);
INSERT INTO Shops VALUES (4, 'Grand', 'Beer Sheva', 'David Tuviyahu Ave 125', 'David Israeli', 10564);

INSERT INTO Toys VALUES (1, 'Toy Truck', 25);
INSERT INTO Toys VALUES (2, 'Barbie doll', 50);
INSERT INTO Toys VALUES (3, 'Teddy Bear', 20);
INSERT INTO Toys VALUES (4, 'Toy Train', 20);
INSERT INTO Toys VALUES (5, '30 ps Puzzle', 25);
INSERT INTO Toys VALUES (6, '100 ps Puzzle', 30);
INSERT INTO Toys VALUES (7, '1000 ps Puzzle', 55);
INSERT INTO Toys VALUES (8, 'Domino', 30);
INSERT INTO Toys VALUES (9, 'Basketball', 35);
INSERT INTO Toys VALUES (10, 'Football', 45);

INSERT INTO Stock VALUES(1, 1, 10);
INSERT INTO Stock VALUES(1, 2, 13);
INSERT INTO Stock VALUES(1, 3, 21);
INSERT INTO Stock VALUES(1, 8, 17);
INSERT INTO Stock VALUES(1, 7, 26);
INSERT INTO Stock VALUES(1, 5, 7);
INSERT INTO Stock VALUES(2, 1, 9);
INSERT INTO Stock VALUES(2, 2, 14);
INSERT INTO Stock VALUES(2, 3, 19);
INSERT INTO Stock VALUES(2, 7, 20);
INSERT INTO Stock VALUES(2, 10, 31);
INSERT INTO Stock VALUES(2, 4, 6);
INSERT INTO Stock VALUES(3, 1, 15);
INSERT INTO Stock VALUES(3, 3, 8);
INSERT INTO Stock VALUES(3, 4, 21);
INSERT INTO Stock VALUES(3, 9, 13);
INSERT INTO Stock VALUES(3, 10, 11);
INSERT INTO Stock VALUES(3, 7, 14);
INSERT INTO Stock VALUES(4, 1, 2);
INSERT INTO Stock VALUES(4, 2, 5);
INSERT INTO Stock VALUES(4, 3, 11);
INSERT INTO Stock VALUES(4, 4, 17);
INSERT INTO Stock VALUES(4, 5, 6);
INSERT INTO Stock VALUES(4, 6, 9);
INSERT INTO Stock VALUES(4, 9, 8);