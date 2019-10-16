var E = window.wangEditor
var editor = new E('#div1','#div2')
//设置上传的参数名
editor.customConfig.uploadFileName = 'file';
// 上传图片到服务器
editor.customConfig.uploadImgServer = '/upload'
// 将图片大小限制为 10M
editor.customConfig.uploadImgMaxSize = 10 * 1024 * 1024;
editor.create()

//点击提交按钮，将内容写入到输入框中
document.getElementById('btn1').addEventListener('click', function () {
    // 读取 text
    document.getElementById("content").value = editor.txt.html();
    document.getElementById("introduction").value = editor.txt.text();
}, false)