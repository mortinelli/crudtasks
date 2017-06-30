CREATE SCHEMA `test` ;

CREATE TABLE test.tasks (

`ID` int(11) NOT NULL AUTO_INCREMENT,

`TASK_NAME` varchar(255) NOT NULL,

`isDone` tinyint(1) NOT NULL,

PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8

INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('1', 'Task1', '1');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('2', 'Task2', '0');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('3', 'Task3', '0');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('4', 'Task4', '0');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('5', 'Task5', '0');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('6', 'Task6', '1');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('7', 'Task7', '1');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('8', 'Task8', '1');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('9', 'Task9', '1');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('10', 'Task10', '1');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('11', 'Task11', '0');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('12', 'Task12', '1');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('13', 'Task13', '0');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('14', 'Task14', '0');
INSERT INTO test.tasks (ID, TASK_NAME, isDone) VALUES ('15', 'Task15', '0');
