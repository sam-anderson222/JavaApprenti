DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_item_with_id`(
	IN user_item_id INT
)
BEGIN
	SELECT ItemID, item.ItemCategoryID, ItemName, ItemDescription, StartDate, EndDate, UnitPrice, ItemCategoryName FROM item
	INNER JOIN itemcategory ic ON item.ItemCategoryID = ic.ItemCategoryID
	WHERE ItemID = user_item_id;
END$$
DELIMITER ;
