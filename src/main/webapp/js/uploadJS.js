const password = document.querySelector(".password");
const passwordConfirm = document.querySelector(".password_confirm");
const categorySelect = document.querySelector("select");
const saveButton = document.querySelector(".save_button");
const fileOne = document.querySelector("#file1");
const fileOnePlaceholder = document.querySelector(".upload_name1");
const fileTwo = document.querySelector("#file2");
const fileTwoPlaceholder = document.querySelector(".upload_name2");
const fileThree = document.querySelector("#file3");
const fileThreePlaceholder = document.querySelector(".upload_name3");


passwordConfirm.addEventListener("change", (e)=>{
  if(e.target.value !== password.value){
    alert("비밀번호가 일치하지 않습니다.")
  }})

fileOne.addEventListener("change",(e)=>{
  fileOnePlaceholder.value = e.target.value;
})
fileTwo.addEventListener("change",(e)=>{
  fileTwoPlaceholder.value = e.target.value;
})
fileThree.addEventListener("change",(e)=>{
  fileThreePlaceholder.value = e.target.value;
})

