
function randomNumber() {
    let randomNumber = Math.floor(Math.random() * 10);
    alert("The magic number is :" + randomNumber);
    let count = 3;
    while (true) {
        count--;
        userValue = prompt("guess a number between 1-10")
        if (userValue == randomNumber) {
            alert("you win!!")
            return
        } else if (count <= 0) {
            alert("you lose!")
            return
        } else {
            alert(`wrong guess! attempts left : ${count}`)
        }
    }
}