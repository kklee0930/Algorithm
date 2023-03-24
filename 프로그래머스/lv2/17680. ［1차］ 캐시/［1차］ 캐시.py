def solution(cacheSize, cities):
    answer = 0
    cache = []
    
    for city in cities:
        city = city.lower()
        
        if city not in cache: # cache miss
            cache.append(city)
            answer += 5
            
        else: # cache hit
            cache.remove(city)
            cache.append(city)
            answer += 1
            
        if len(cache) > cacheSize: # 캐시 사이즈 초과시
            cache.remove(cache[0]) # 가장 아래의 도시 제거
            
    return answer