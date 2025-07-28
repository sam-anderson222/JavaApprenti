DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_available_items`(
	IN cur_date date
)
BEGIN
	SELECT ItemID, item.ItemCategoryID, ItemName, ItemDescription, StartDate, EndDate, UnitPrice, ItemCategoryName FROM item
		INNER JOIN itemcategory ic ON item.ItemCategoryID = ic.ItemCategoryID
		WHERE (cur_date BETWEEN StartDate AND EndDate) OR
		(EndDate IS NULL AND cur_date >= StartDate);
END$$
DELIMITER ;
