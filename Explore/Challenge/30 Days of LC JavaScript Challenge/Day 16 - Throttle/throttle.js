/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var throttle = function(fn, t) {
    let timeoutInProgress = null;
    let argsToProcess = null

    const timeoutFunction = () => {
        if (argsToProcess === null) {
            timeoutInProgress = null;
        } else {
            fn(...argsToProcess);
            argsToProcess = null;
            timeoutInProgress = setTimeout(timeoutFunction, t);
        }
    }

    return function(...args) {
        if (timeoutInProgress) {
            argsToProcess = args;
        } else {
            fn(...args);
            timeoutInProgress = setTimeout(timeoutFunction, t);
        }
    }
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */