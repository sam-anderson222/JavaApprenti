DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_order_with_details`(
	IN user_order_id INT
)
BEGIN


SELECT o.OrderID, o.ServerID, o.OrderDate, o.SubTotal, o.Tax, o.Tip, o.Total, s.FirstName, s.LastName, s.HireDate, s.TermDate  FROM `order` o
INNER JOIN server s ON o.ServerID = s.ServerID
WHERE OrderID = user_order_id;

SELECT oi.OrderItemID, oi.OrderID, oi.ItemID, oi.Quantity, oi.Price, i.ItemCategoryID, i.ItemName, i.ItemDescription, i.StartDate, i.EndDate, i.UnitPrice, ic.ItemCategoryName FROM orderitem oi
INNER JOIN item i ON oi.ItemID = i.ItemID
INNER JOIN itemcategory ic ON ic.ItemCategoryID = i.ItemCategoryID
WHERE oi.OrderID = user_order_id;

SELECT p.PaymentID, p.OrderID, p.PaymentTypeID, p.Amount, pt.PaymentTypeName FROM payment p
INNER JOIN paymenttype pt ON p.PaymentTypeID = pt.PaymentTypeID
WHERE p.OrderID = user_order_id;
END$$
DELIMITER ;
