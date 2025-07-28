DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_available_item_from_category`(
	IN cur_date DATE,
	IN user_item_id INT
)
BEGIN
	SELECT ItemID, item.ItemCategoryID, ItemName, ItemDescription, StartDate, EndDate, UnitPrice, ItemCategoryName FROM item
		INNER JOIN itemcategory ic ON item.ItemCategoryID = ic.ItemCategoryID
		WHERE (item.ItemCategoryID = user_item_id) AND
		((cur_date BETWEEN StartDate AND EndDate) OR
		(EndDate IS NULL AND cur_date >= StartDate));
END$$
DELIMITER ;
