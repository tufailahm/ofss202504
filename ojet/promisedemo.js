// Create a promise
const myPromise = new Promise((resolve, reject) => {
  let success = true; 

  if (success) {
    resolve("Promise resolved successfully!");
  } else {
    reject("Promise failed!");
  }
});

// Use the promise
myPromise
  .then(result => {
    console.log(result); // If resolved
  })
  .catch(error => {
    console.error(error); // If rejected
  });
