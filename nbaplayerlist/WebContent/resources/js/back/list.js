/**
 * Invoke deleteBatch method in back-end by temporary form url
 */
function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"DeleteBatch.action");
	$("#mainForm").submit();
}