package main

import (
    "sort"
)

type pair struct {
    node, depth int
}

func numBusesToDestination(routes [][]int, source int, target int) int {
    if source == target {
        return 0
    }

    n := len(routes)

    graph := make([][]int, n)
    for i := 0; i < n; i++ {
        sort.Ints(routes[i])
    }
    for i := 0; i < n; i++ {
        for j := i+1; j < n; j++ {
            if (intersect(routes[i], routes[j])) {
                graph[i] = append(graph[i], j)
                graph[j] = append(graph[j], i)
            }
        }
    }

    visited := make(map[int]bool)
    targets := make(map[int]bool)
    queue := make([]pair, 0)
    for i := 0; i< n; i++ {
        if contains(routes[i], source) {
            visited[i] = true
            queue = append(queue, pair{i, 0})
        }
        if contains(routes[i], target) {
            targets[i] = true
        }
    }

    for len(queue) > 0 {
        curr := queue[0]
        queue = queue[1:]

        node, depth := curr.node, curr.depth
        _, ok := targets[node]
        if ok {
            return depth + 1
        }

        for _, neighbor := range graph[node] {
            _, seen := visited[neighbor]
            if !seen {
                visited[neighbor] = true
                queue = append(queue, pair{neighbor, depth+1})
            }
        }
    }

    return -1
}

func intersect(bus1 []int, bus2 []int) bool {
    i, j := 0, 0
    for i < len(bus1) && j < len(bus2) {
        if bus1[i] == bus2[j] {
            return true
        }

        if bus1[i] < bus2[j] {
            i++
        } else {
            j++
        }
    }
    return false
}

func contains(slice []int, element int) bool {
    for _, curr := range slice {
        if curr == element {
            return true
        }
    }
    return false
}
