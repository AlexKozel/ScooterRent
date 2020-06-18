DROP TABLE IF EXISTS `senla`.`User`;

CREATE TABLE IF NOT EXISTS `senla`.`User`
(
    `UserId`     INT         NOT NULL,
    `FirstName`  VARCHAR(45) NOT NULL,
    `SecondName` VARCHAR(45) NOT NULL,
    `Role`       VARCHAR(45) NOT NULL,
    `DiscountId` INT         NULL,
    PRIMARY KEY (`UserId`));