/**
 * 
 */
function countDown() {
  const now = new Date();
  const targetTime = new Date(`Feb 10, ${now.getFullYear()} 00:00:00`);

  const diff = targetTime - now;

  const d = Math.floor(diff / (24 * 60 * 60 * 1000));
  const h = Math.floor(diff / (60 * 60 * 1000)) % 24;
  const m = Math.floor(diff / (60 * 1000)) % 60;
  const s = Math.floor(diff / 1000) % 60;

  document.getElementById('days').innerHTML = d;
  document.getElementById('hours').innerHTML = ("0" + h).slice(-2);
  document.getElementById('minutes').innerHTML = ("0" + m).slice(-2);
  document.getElementById('seconds').innerHTML = ("0" + s).slice(-2);
}


setInterval(countDown, 1000);

/*const checkbox = document.getElementById("checkbox")
checkbox.addEventListener("change", () => {
  document.body.classList.toggle("dark")
})
*/