DROP TABLE IF EXISTS `stinjan_app`.`reservation`;
DROP TABLE IF EXISTS `stinjan_app`.`user`;
DROP TABLE IF EXISTS `stinjan_app`.`permission`;
DROP TABLE IF EXISTS `stinjan_app`.`trip`;
DROP TABLE IF EXISTS `stinjan_app`.`parking`;
DROP TABLE IF EXISTS `stinjan_app`.`apartment`;
DROP TABLE IF EXISTS `stinjan_app`.`lunch`;
DROP TABLE IF EXISTS `stinjan_app`.`gallery`;
DROP TABLE IF EXISTS `stinjan_app`.`role`;

CREATE TABLE `stinjan_app`.`trip` (
  `tripId` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `price` INT DEFAULT NULL,
  `image` BLOB,
  `description` VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (`tripId`));
  
CREATE TABLE `stinjan_app`.`parking` (
	`parkingId` INT NOT NULL AUTO_INCREMENT,
    `serial_num` INT UNIQUE,
    `available` BIT DEFAULT NULL,
    PRIMARY KEY (`parkingId`)
);

CREATE TABLE `stinjan_app`.`apartment` (
	`apartmentId` INT NOT NULL AUTO_INCREMENT,
    `num_of_rooms` INT NOT NULL,
    `num_of_beds` INT NOT NULL,
    `description` VARCHAR(200) DEFAULT NULL,
    `image` BLOB,
    `price_per_night` INT NOT NULL,
    PRIMARY KEY (`apartmentId`)
);

CREATE TABLE `stinjan_app`.`lunch` (
	`lunchId` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(45) NOT NULL,
    `price` INT NOT NULL,
    `image` BLOB,
    `description` VARCHAR(200) DEFAULT NULL,
    PRIMARY KEY (`lunchId`)
);

CREATE TABLE `stinjan_app`.`gallery` (
	`imgId` INT NOT NULL AUTO_INCREMENT,
    `img` BLOB,
    `description` VARCHAR(200) DEFAULT NULL,
    PRIMARY KEY (`imgId`)
);

CREATE TABLE `stinjan_app`.`role` (
	`roleId` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(200) DEFAULT NULL,
    PRIMARY KEY (`roleId`)
);

CREATE TABLE `stinjan_app`.`permission` (
	`permissionId` INT NOT NULL AUTO_INCREMENT,
    `roleId` INT NOT NULL,
    `tableName` VARCHAR(50) NOT NULL,
    `canCreate` bit(1) DEFAULT NULL,
    `canRead` bit(1) DEFAULT NULL,
    `canDelete` bit(1) DEFAULT NULL,
    `canUpdate` bit(1) DEFAULT NULL,
    PRIMARY KEY (`permissionId`),
    KEY `fk_permission_role` (`roleId`),
    CONSTRAINT `fk_permission_role` FOREIGN KEY (`roleId`) 
    REFERENCES `stinjan_app`.`role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `stinjan_app`.`user` (
	`userId` INT NOT NULL AUTO_INCREMENT,
    `roleId` INT NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `surname` VARCHAR(50) NOT NULL,
    `country` VARCHAR(50) DEFAULT NULL,
    `city` VARCHAR(50) DEFAULT NULL,
    `address` VARCHAR(50) DEFAULT NULL,
    `email` VARCHAR(50) NOT NULL,
    `phone` VARCHAR(50) NOT NULL,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `description` VARCHAR(200) DEFAULT NULL,
    PRIMARY KEY (`userId`),
    KEY `fk_user_role` (`roleId`),
    CONSTRAINT `fk_user_role` FOREIGN KEY (`roleId`)
    REFERENCES `stinjan_app`.`role` (`roleId`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `stinjan_app`.`reservation` (
	`reservationId` INT NOT NULL AUTO_INCREMENT,
    `dateFrom` DATE NOT NULL,
    `dateTo` DATE NOT NULL,
    `totalPrice` INT NOT NULL,
    `tripId` INT NOT NULL,
    `parkingId` INT NOT NULL,
    `apartmentId` INT NOT NULL,
    `userId` INT NOT NULL,
    PRIMARY KEY (`reservationId`),
    KEY `fk_reservation_trip` (`tripId`),
    KEY `fk_reservation_parking` (`parkingId`),
    KEY `fk_reservation_apartment` (`apartmentId`),
    KEY `fk_reservation_user` (`userId`),
    CONSTRAINT `fk_reservation_trip` FOREIGN KEY (`tripId`) 
    REFERENCES `stinjan_app`.`trip` (`tripId`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_reservation_parking` FOREIGN KEY (`parkingId`) 
    REFERENCES `stinjan_app`.`parking` (`parkingId`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_reservation_apartment` FOREIGN KEY (`apartmentId`) 
    REFERENCES `stinjan_app`.`apartment` (`apartmentId`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `fk_reservation_user` FOREIGN KEY (`userId`) 
    REFERENCES `stinjan_app`.`user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
);