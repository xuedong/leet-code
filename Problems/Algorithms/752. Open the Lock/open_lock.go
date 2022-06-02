import (
    "strconv"
)

func openLock(deadends []string, target string) int {
    visited := make(map[string]bool)
    for _, deadend := range deadends {
        visited[deadend] = true
    }

    if visited["0000"] {
        return -1
    }
    visited["0000"] = true

    queue := []string{"0000"}
    ans := 0
    for len(queue) > 0 {
        length := len(queue)
        for k := 1; k <= length; k++ {
            currString := queue[0]
            queue = queue[1:]
            if currString == target {
                return ans
            }

            for i := 0; i < 4; i++ {
                j := (int(currString[i]-'0') + 1) % 10
				newString := currString[:i] + strconv.Itoa(j) + currString[i+1:]
                if !visited[newString] {
                    visited[newString] = true
                    queue = append(queue, newString)
                }

                j = (int(currString[i]-'0') + 9) % 10
				newString = currString[:i] + strconv.Itoa(j) + currString[i+1:]
                if !visited[newString] {
                    visited[newString] = true
                    queue = append(queue, newString)
                }
            }
        }

        ans++
    }

    return -1
}
