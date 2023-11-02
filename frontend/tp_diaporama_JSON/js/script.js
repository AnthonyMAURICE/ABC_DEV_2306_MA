const carouselButton = document.getElementById('button-carousel');
const carouselItems = document.getElementById('items-carousel');
//const carouselMain = document.getElementById('carouselExampleCaptions');

getData();

async function getData(){
    const response = await fetch("../json/data.json");
    let datas = await response.json();
    injectData(datas);
}

function injectData(elements){
    for(let j = 0; j < elements.datas.length; j++){
        if(j == 0){
            carouselItems.innerHTML += `<div class="carousel-item active">
                                    <img src="${elements.datas[j].image}" class="d-block w-100" alt="${elements.datas[j].alt}">
                                    <div class="carousel-caption d-none d-md-block">
                                        <h5></h5>
                                        <p>"${elements.datas[j].description}"</p>
                                    </div>
                                </div>`
        }else{
            carouselItems.innerHTML += `<div class="carousel-item">
                                        <img src="${elements.datas[j].image}" class="d-block w-100" alt="${elements.datas[j].alt}">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5></h5>
                                            <p>"${elements.datas[j].description}"</p>
                                        </div>
                                    </div>`
        }
    }

    for(let i = 0; i < elements.datas.length; i++){
        if(i == 0){
            carouselButton.innerHTML += `<button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class= "active" aria-current = "true" aria-label="Slide 1"></button>`
        }else{
            carouselButton.innerHTML += `<button type="button" class="carousel-buttons" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="${elements.datas[i].id}" aria-current="true" class="carousel-buttons" aria-label="Slide ${elements.datas[i].id + 1}"></button>`;
        }
    }

    /*
    carouselMain.innerHTML += `<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>`
    */
    //let temp = setActive(elements, 0);

    //setActive(elements, 0);
    //console.log(temp)
    /*
    for(let k = 0; k < carouselButtonActive.length; k++){
        carouselButtonActive[k].addEventListener("click", () => setActive(elements, k));
        temp = setActive(elements, k)
    }
    
    console.log(temp)
    const prevButton = document.getElementById('prev');
    const nextButton = document.getElementById('next');
    */
    /*
    prevButton.addEventListener("click", () => test(elements, true))
    nextButton.addEventListener("click", () => test(elements, false))
    */
}
/*
function test(elements, previous){
    let carouselActive = document.getElementById();
    console.log(carouselActive);
    if(previous){
        
    }else{
        
    }
}


function setActive(elements, index){
    let carouselActive = document.getElementById(elements.datas[index].id);
    console.log(carouselActive.id);
    let carousel = document.getElementsByClassName("carousel-item");
    for(let i = 0; i < carousel.length; i++){
        carousel[i].classList.remove("active");
    }
    carouselActive.classList.add("active");
    return carouselActive.id;
}
*/