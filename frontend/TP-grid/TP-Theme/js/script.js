const change = document.getElementById('theme-change');
change.addEventListener("click", changeTheme);
const buy = document.getElementById('purchase');
buy.addEventListener("click", buyFunction);
let darkMode = window.matchMedia('(prefers-color-scheme: dark)').matches;
const bodyClasses = document.querySelector('main').classList;
change.innerHTML = darkMode? "Light" : "Dark";

function changeTheme(){
    change.innerHTML = darkMode? "Dark" : "Light";
    if(!darkMode){
        bodyClasses.remove('light-mode');
        bodyClasses.toggle('dark-mode');
        darkMode = true;
        
    }else{
        bodyClasses.remove('dark-mode');
        bodyClasses.toggle('light-mode');
        darkMode = false;
    }
}

function buyFunction(){
    alert("Achat effectué ! Vote compte a été débité de plein d'argent d'un coup !");
}