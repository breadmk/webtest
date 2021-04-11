$(function(){
	
	$(".deleteOk").click(function(){
		
		if(deleteCheck()==true){
		var mno = $(this).parents('tr').find("#mno").text();
		location.href="deleteOk?mno="+mno;
		}else{
			location.href="list";
		}
	})
	
	$(".update").click(function(){
		var mno = $(this).parents('tr').find("#mno").text();
		location.href="update?mno="+mno;
	})
	
	$("#down").click(function(){
		location.href="downloadCSV";
	})
})

function deleteCheck(){
	if(confirm("정말 삭제하시겠습니까?")==true){
		return true;
	}else{
		return false;
	}
}