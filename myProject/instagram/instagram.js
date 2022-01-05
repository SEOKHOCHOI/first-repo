window.onload=()=>{
  let introLayer = document.getElementById('intro');
  let opacity = 100;
  let interval = setInterval(()=>{
      introLayer.style.opacity=opacity/100;
      opacity--;

      if(opacity===0){
          clearInterval(interval);
          introLayer.remove();
      }
  },10);              
}

function popup(){
let pop = document.getElementById('pop1');
pop.style.display='flex';
}

function closePopup(){
document.getElementById('pop1').style.display='none';
}

function popup02(){
  let pop = document.getElementById('pop02');
  pop.style.display='flex';
  }
  
  function closePopup02(){
  document.getElementById('pop02').style.display='none';
  }
  

function like(elem){
  let state = JSON.parse(elem.dataset.state);
  elem.dataset.state=!state;
  if(state===false){
      elem.innerText='favorite';
      elem.style.color='red'
  }else{
      elem.innerText='favorite_border';
      elem.style.color='';
  }
}

function love(heart){
  let state = JSON.parse(heart.dataset.state);
  heart.dataset.state=!state;
  if(state===false){
    heart.innerText='♥';
    heart.style.color='red';
  }else{
    heart.innerText='♡';
    heart.style.color='';
  }
}


function book(mark){
  let state = JSON.parse(mark.dataset.state);
  mark.dataset.state=!state;
  if(state===false){
    mark.innerText='bookmark';
  }else{
    mark.innerText='bookmark_border';
  }
}