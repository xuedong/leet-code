impl Solution {
    pub fn all_paths_source_target(graph: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut results = vec![];
        let mut path = vec![0];
        
        aux(&graph, &mut results, &mut path, 0, graph.len()-1);
        results
    }
}

pub fn aux(graph: &Vec<Vec<i32>>, results: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, src: i32, target: usize) {
    if src as usize == target {
        results.push(path.clone());
        return
    }
        
    if graph[src as usize].len() == 0 {
        return
    }
        
    for neighbor in graph[src as usize].iter().copied() {
        path.push(neighbor);
        aux(graph, results, path, neighbor, target);
        path.pop();
    }
}

