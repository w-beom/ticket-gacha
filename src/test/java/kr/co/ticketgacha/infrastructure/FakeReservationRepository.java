package kr.co.ticketgacha.infrastructure;

import kr.co.ticketgacha.domain.reservation.Reservation;
import kr.co.ticketgacha.domain.reservation.ReservationRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FakeReservationRepository implements ReservationRepository {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Reservation> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Reservation> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Reservation> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Reservation getOne(Long aLong) {
        return null;
    }

    @Override
    public Reservation getById(Long aLong) {
        return null;
    }

    @Override
    public Reservation getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Reservation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Reservation> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Reservation> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Reservation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Reservation> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Reservation> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Reservation, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Reservation> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Reservation> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Reservation> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Reservation> findAll() {
        return null;
    }

    @Override
    public List<Reservation> findAllById(Iterable<Long> longs) {
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
    public void delete(Reservation entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Reservation> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Reservation> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Reservation> findAll(Pageable pageable) {
        return null;
    }
}
