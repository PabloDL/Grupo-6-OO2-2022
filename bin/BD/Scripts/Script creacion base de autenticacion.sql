-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Grupo-6-BDD-OO2-2022
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Grupo-6-BDD-OO2-2022
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Grupo-6-BDD-OO2-2022` DEFAULT CHARACTER SET utf8 ;
USE `Grupo-6-BDD-OO2-2022` ;

-- -----------------------------------------------------
-- Table `Grupo-6-BDD-OO2-2022`.`Autenticacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo-6-BDD-OO2-2022`.`Autenticacion` (
  `usuario` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NULL,
  PRIMARY KEY (`usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo-6-BDD-OO2-2022`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo-6-BDD-OO2-2022`.`perfil` (
  `idPerfil` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPerfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo-6-BDD-OO2-2022`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo-6-BDD-OO2-2022`.`usuario` (
  `idUsuario` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `tipoDocumento` VARCHAR(45) NULL,
  `nroDocumento` VARCHAR(45) NOT NULL,
  `email` VARCHAR(90) NULL,
  `Autenticacion_usuario1` VARCHAR(45) NOT NULL,
  `perfil_idPerfil` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_Autenticacion1_idx` (`Autenticacion_usuario1` ASC) VISIBLE,
  INDEX `fk_usuario_perfil1_idx` (`perfil_idPerfil` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_Autenticacion1`
    FOREIGN KEY (`Autenticacion_usuario1`)
    REFERENCES `Grupo-6-BDD-OO2-2022`.`Autenticacion` (`usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_perfil1`
    FOREIGN KEY (`perfil_idPerfil`)
    REFERENCES `Grupo-6-BDD-OO2-2022`.`perfil` (`idPerfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo-6-BDD-OO2-2022`.`permisos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo-6-BDD-OO2-2022`.`permisos` (
  `idpermisos` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `habilitado` BIT(1) NOT NULL,
  PRIMARY KEY (`idpermisos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Grupo-6-BDD-OO2-2022`.`permisos_has_perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Grupo-6-BDD-OO2-2022`.`permisos_has_perfil` (
  `permisos_idpermisos` INT NOT NULL,
  `perfil_idPerfil` INT NOT NULL,
  PRIMARY KEY (`permisos_idpermisos`, `perfil_idPerfil`),
  INDEX `fk_permisos_has_perfil_perfil1_idx` (`perfil_idPerfil` ASC) VISIBLE,
  INDEX `fk_permisos_has_perfil_permisos1_idx` (`permisos_idpermisos` ASC) VISIBLE,
  CONSTRAINT `fk_permisos_has_perfil_permisos1`
    FOREIGN KEY (`permisos_idpermisos`)
    REFERENCES `Grupo-6-BDD-OO2-2022`.`permisos` (`idpermisos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_permisos_has_perfil_perfil1`
    FOREIGN KEY (`perfil_idPerfil`)
    REFERENCES `Grupo-6-BDD-OO2-2022`.`perfil` (`idPerfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
