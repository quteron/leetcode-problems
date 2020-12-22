func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
    // declare map to collect pairs as number -> its index in the array
    var map = [Int: Int]()

    // iterate over numbers in the array
    for i in 0..<nums.count {
        // get current number
        let num = nums[i]
        // calculate second number to have sum of target
        let diff = target - num
        // check if has already passed second number
        if let j = map[diff] {
            // if yes, return indices
            return [j, i]
        } else {
            // if no, save current number and its index
            map[num] = i
        }
    }

    // should never be here
    return [-1, -1]
}

let ans = twoSum([2,7,11,15], 9)
print(ans)
