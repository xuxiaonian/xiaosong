// function upPic(obj){
//     var fd = new FormData();
//
//     fd.append("imgFile",obj.files[0]);
//     $.ajax({
//         url : '/uploadFile?updateImg',
//         type : "POST",
//         processData : false,
//         contentType : false,
//         data : fd,
//         success : function(data) {
//             $("#lly").remove();
//             $("#llypic").append("<div id='lly'><img  style='height: 150px;width: 130px' src='"+data+"'></img><input type='hidden'  name='picUrl' value='"+data+"'/>"
//                 +"<div><a href='javascript:void(0)'  onclick='picRemove(0)'>删除</a></div></div>")
//
//         }
//     })
// }
function upPic(obj){
    var fd = new FormData();

    fd.append("imgFile",obj.files[0]);
    $.ajax({
        url : '/uploadFile?updateImg',
        type : "POST",
        processData : false,
        contentType : false,
        data : fd,
        success : function(data) {
            $("#lly").remove();
            $("#llypic").append("<div id='lly'><img  style='height: 150px;width: 130px' src='"+data+"'></img><input type='hidden'  name='picUrl' value='"+data+"'/>"
                +"<div><a href='javascript:void(0)'  onclick='picRemove(0)'>删除</a></div></div>")

        }
    })
}
function picRemove(obj){

    $("#lly").remove();
}