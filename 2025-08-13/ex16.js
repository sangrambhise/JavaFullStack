const images = ["https://myrightbird.com/assets/uploads/mybird_yellow_crowned_mischief-900x675.jpg", "https://upload.wikimedia.org/wikipedia/commons/3/37/African_Bush_Elephant.jpg", "https://i.natgeofe.com/k/02aad54b-bcd8-4a3a-8659-f08bb98b1a01/ww-wild-cats-lion_3x2.jpg", "https://a-z-animals.com/media/2022/09/iStock-492611032.jpg"];

let currentIndex = 0;
const imageGallery = document.getElementById("imageGallery");

function updateImage() {
  imageGallery.src = images[currentIndex];
}

function showNext() {
  currentIndex = (currentIndex + 1) % images.length;
  updateImage();
}

function showPrev() {
  currentIndex = (currentIndex - 1 + images.length) % images.length;
  updateImage();
}

updateImage();
