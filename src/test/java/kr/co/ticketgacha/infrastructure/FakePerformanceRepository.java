package kr.co.ticketgacha.infrastructure;

import kr.co.ticketgacha.domain.performance.Performance;
import kr.co.ticketgacha.domain.performance.PerformanceRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FakePerformanceRepository implements PerformanceRepository {
    private Long id = 1L;
    private List<Performance> performances = new ArrayList<>();

    @Override
    public void flush() {
    }

    @Override
    public <S extends Performance> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Performance> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Performance> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Performance getOne(Long aLong) {
        return null;
    }

    @Override
    public Performance getById(Long aLong) {
        return null;
    }

    @Override
    public Performance getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Performance> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Performance> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Performance> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Performance> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Performance> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Performance> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Performance, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Performance> S save(S entity) {
        entity.setPerformanceId(id++);
        performances.add(entity);
        return entity;
    }

    @Override
    public <S extends Performance> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Performance> findById(Long id) {
        return performances.stream()
                .filter(performance -> performance.getPerformanceId().equals(id))
                .findFirst();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Performance> findAll() {
        return null;
    }

    @Override
    public List<Performance> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Performance entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Performance> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Performance> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Performance> findAll(Pageable pageable) {
        return null;
    }
}
