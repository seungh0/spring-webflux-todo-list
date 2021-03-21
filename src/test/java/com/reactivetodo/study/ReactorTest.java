package com.reactivetodo.study;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class ReactorTest {

	@Test
	void test_one() {
		// when
		Flux<String> flux = Flux.just("will", "erin");

		// then
		StepVerifier.create(flux)
				.expectNext("will")
				.expectNext("erin")
				.verifyComplete();
	}

	@Test
	void test_two() {
		// given
		String[] fruits = new String[]{"will", "erin"};

		// when
		Flux<String> fruitFlux = Flux.fromArray(fruits);

		// then
		StepVerifier.create(fruitFlux)
				.expectNext("will")
				.expectNext("erin")
				.verifyComplete();
	}

	@Test
	void test_three() {
		// given
		List<String> fruitList = Arrays.asList("will", "erin");

		// when
		Flux<String> fruitFlux = Flux.fromIterable(fruitList);

		// then
		StepVerifier.create(fruitFlux)
				.expectNext("will")
				.expectNext("erin")
				.verifyComplete();
	}

	@Test
	void test_four() {
		// given
		List<String> fruit1List = Arrays.asList("will", "erin");
		List<String> fruit2List = Arrays.asList("seungho", "yerim");

		Flux<String> fruitFlux1 = Flux.fromIterable(fruit1List);
		Flux<String> fruitFlux2 = Flux.fromIterable(fruit2List);

		// when
		Flux<String> fruitFlux = fruitFlux1.mergeWith(fruitFlux2);
		// 단, 완벽하게 번갈아 방출되게 보장할 수 없음

		// then
		StepVerifier.create(fruitFlux)
				.expectNext("will")
				.expectNext("erin")
				.expectNext("seungho")
				.expectNext("yerim")
				.verifyComplete();
	}

	@Test
	void test_five() {
		// given
		List<String> fruit1List = Arrays.asList("will", "erin");
		List<String> fruit2List = Arrays.asList("seungho", "yerim");

		Flux<String> fruitFlux1 = Flux.fromIterable(fruit1List);
		Flux<String> fruitFlux2 = Flux.fromIterable(fruit2List);

		// when
		Flux<String> fruitFlux = Flux.zip(fruitFlux1, fruitFlux2, (one, two) -> one + " is " + two);

		// then
		StepVerifier.create(fruitFlux)
				.expectNext("will is seungho")
				.expectNext("erin is yerim")
				.verifyComplete();
	}

	@Test
	void test_six() {
		// when
		Flux<String> flux = Flux.just("will", "erin", "yerim", "seungho")
				.skip(2);

		// then
		StepVerifier.create(flux)
				.expectNext("yerim")
				.expectNext("seungho")
				.verifyComplete();
	}

	@Test
	void test_seven() {
		// when
		Flux<String> flux = Flux.just("will", "erin", "yerim", "seungho")
				.take(2);

		// then
		StepVerifier.create(flux)
				.expectNext("will")
				.expectNext("erin")
				.verifyComplete();
	}

	@Test
	void test_eight() {
		// when
		Flux<String> flux = Flux.just("will", "erin", "yerim", "seungho")
				.filter(name -> name.length() == 4);

		// then
		StepVerifier.create(flux)
				.expectNext("will")
				.expectNext("erin")
				.verifyComplete();
	}

	@Test
	void test_nine() {
		// when
		Flux<String> flux = Flux.just("will", "erin", "will", "erin")
				.distinct();

		// then
		StepVerifier.create(flux)
				.expectNext("will")
				.expectNext("erin")
				.verifyComplete();
	}

	@Test
	void test_11() {
		// when
		Flux<String> flux = Flux.just("will", "erin")
				.map(String::toUpperCase);

		// then
		StepVerifier.create(flux)
				.expectNext("WILL")
				.expectNext("ERIN")
				.verifyComplete();
	}

	@Test
	void test_12() {
		// when
		Flux<String> flux = Flux.just("will", "erin")
				.flatMap(name -> Mono.just(name.toUpperCase()));

		// then
		StepVerifier.create(flux)
				.expectNext("WILL")
				.expectNext("ERIN")
				.verifyComplete();
	}

	@Test
	void test_all() {
		// when
		Flux<String> flux = Flux.just("will", "erin");

		Mono<Boolean> allMono = flux.all(name -> name.length() == 4);

		// then
		StepVerifier.create(allMono)
				.expectNext(true)
				.verifyComplete();
	}

	@Test
	void test_all2() {
		// when
		Flux<String> flux = Flux.just("will", "erin");

		Mono<Boolean> allMono = flux.all(name -> name.startsWith("wi"));

		// then
		StepVerifier.create(allMono)
				.expectNext(false)
				.verifyComplete();
	}

	@Test
	void test_any() {
		// when
		Flux<String> flux = Flux.just("will", "erin");

		Mono<Boolean> allMono = flux.any(name -> name.startsWith("wi"));

		// then
		StepVerifier.create(allMono)
				.expectNext(true)
				.verifyComplete();
	}

}
