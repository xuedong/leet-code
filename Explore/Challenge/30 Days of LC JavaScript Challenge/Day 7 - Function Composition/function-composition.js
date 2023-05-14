/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
	return function(x) {
        if (functions.length == 0) return x;

        let output = x;
        for (const fn of functions.reverse()) {
            output = fn(output);
        }
        return output;
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */