// worker.js
self.onmessage = function (event) {
  const num = event.data;
  let result = 0;

  // simulate heavy calculation
  for (let i = 0; i < num; i++) {
    result += i;
  }

  // send result back to main thread
  self.postMessage(result);
};
