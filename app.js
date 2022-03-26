const adviceNumber = document.getElementById("title-number");
const adviceMessage = document.getElementById("advice");
const button = document.getElementById("btn");
const apiURL = "	https://api.adviceslip.com/advice";

async function fetchAdvice() {
  try {
    const response = await fetch(apiURL);
    if (!response.ok) {
      throw new Error(`HTTP error: ${response.status}`);
    }
    return await response.json();
  } catch (e) {
    console.error(e);
  }
}

button.addEventListener("click", () => {
  fetchAdvice().then((advice) => {
    const slip = advice.slip;

    adviceNumber.innerText = slip.id;
    adviceMessage.innerText = `"${slip.advice}"`;
  });
});
