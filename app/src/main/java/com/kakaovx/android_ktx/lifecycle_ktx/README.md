
* Lifecycle의 CoroutineScope를 만드는 방법 두가지
1. lifecycle.coroutineScope.launch { // ... }
2. lifecycleScope.launch { // ... }

* 수집할 Flow가 1개일 경우, 사용할 수 있는 launch
- flowWithLifecycle()

* 수집할 Flow가 2개 이상일 경우, 사용할 수 있는 launch
- repeatOnLifecycle()

* Lifecycle중 해당 상태때 딱 한번, 일시중단 블록을 호출해준다.
- whenStateAtLeast()

* Lifecycle중 해당 상태때 딱 한번, 일반함수 블록을 호출해준다. 
- withStateAtLeast()

정리한 내용 : https://cncn6666.tistory.com/entry/KTX-AAC-Lifecycles%EC%9D%98-%EB%AA%A8%EB%93%A0-%EA%B2%83-AndroidX-Lifecycle-KTX