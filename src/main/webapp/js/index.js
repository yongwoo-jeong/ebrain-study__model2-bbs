const startDate = document.querySelector(".start_date");
const endDate = document.querySelector(".end_date");


function searchParam(key) {
  return new URLSearchParams(location.search).get(key);
}

startDate.value = searchParam("start_date");
endDate.value = searchParam("last_date");