window.onload=function () {
    const input=document.getElementById("text");
    const counter=document.getElementById("count");
    const maxlen=50;
    input.addEventListener("input", function () {
        const rem=maxlen-input.value.length;
        counter.innerText=rem+" characters remaining";
    });
};
