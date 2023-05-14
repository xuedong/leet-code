/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let cum = init;
    for (const element of nums) {
        cum = fn(cum, element);
    }
    return cum;
};
