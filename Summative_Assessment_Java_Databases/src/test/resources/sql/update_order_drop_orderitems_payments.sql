DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_order_drop_orderitems_payments`(
	IN old_order_id INT,
	IN new_server_id INT,
    IN new_order_date DATE,
    IN new_subtotal DECIMAL(9,2),
    IN new_tax DECIMAL(9,2),
    IN new_tip DECIMAL(9,2),
    IN new_total DECIMAL(9,2),
    OUT rows_affected INT
)
BEGIN
	UPDATE `order`
    SET ServerID = new_server_id,
    OrderDate = new_order_date,
    SubTotal = new_subtotal,
    Tax = new_tax,
    Tip = new_tip,
    Total = new_total
    WHERE OrderID = old_order_id;

    SET rows_affected = ROW_COUNT();

    DELETE FROM orderitem WHERE OrderID = old_order_id;
    DELETE FROM payment WHERE OrderID = old_order_id;
END$$
DELIMITER ;
