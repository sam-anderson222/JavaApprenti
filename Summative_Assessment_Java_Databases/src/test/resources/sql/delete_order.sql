DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_order`(
	IN user_order_id INT
)
BEGIN
    DELETE FROM orderitem WHERE OrderID = user_order_id;
    DELETE FROM payment WHERE OrderID = user_order_id;
    DELETE FROM `order` WHERE OrderID = user_order_id;
END$$
DELIMITER ;
