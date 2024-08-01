package com.example.desafio.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.desafio.exception.ResourceNotFoundException;
import com.example.desafio.model.Postulacion;
import com.example.desafio.repository.DepartamentoRepository;
import com.example.desafio.repository.FacultadRepository;
import com.example.desafio.repository.PostulacionRepository;

// se definen los servicios para manejar la logica de negocio, se realiza lo mismo para Facultad y Departamento

@Service //Se indica que la siguiente clase sera un servicio
@SuppressWarnings("null") //Se evitan las advertencias de tipo "null"
public class PostulacionService implements PostulacionRepository {

    @Autowired //Para inyectar automaticamente una instancia del repositorio de postulacion
    public PostulacionRepository postulacionRepository;

    @Autowired
    private FacultadRepository facultadRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    //Los siguientes métodos fueron generados automaticamente por el editor
    //Se modificaron solo los que se van a utilizar

    //Método para listar todas las postulaciones
    @Override
    public List<Postulacion> findAll() {
        return postulacionRepository.findAll();
    }

    //Método para listar una postulacion por su codigo
    @Override
    public Optional<Postulacion> findById(Long codigo) {
        return postulacionRepository.findById(codigo);
    }

    //Método para crear una postulacion
    public Postulacion createPostulacion(Postulacion postulacion) {
        postulacion.setFecha(LocalDate.now());
        // Validar facultad y departamento
        if (!facultadRepository.existsById(postulacion.getFacultad().getId())) {
            throw new ResourceNotFoundException("Facultad no encontrada");
        }
        if (!departamentoRepository.existsById(postulacion.getDepartamento().getId())) {
            throw new ResourceNotFoundException("Departamento no encontrado");
        }
        return postulacionRepository.save(postulacion);
    }

    //Método para editar una postulacion
    public Postulacion updatePostulacion(Long codigo, Postulacion postulacionDetails) {
        Postulacion postulacion = postulacionRepository.findById(codigo)
            .orElseThrow(() -> new ResourceNotFoundException("Postulacion not found with id " + codigo));
        postulacion.setRut(postulacionDetails.getRut());
        postulacion.setTituloPostulacion(postulacionDetails.getTituloPostulacion());
        postulacion.setFacultad(postulacionDetails.getFacultad());
        postulacion.setDepartamento(postulacionDetails.getDepartamento());
        postulacion.setCorreo(postulacionDetails.getCorreo());
        postulacion.setFecha(postulacionDetails.getFecha());
        return postulacionRepository.save(postulacion);
    }

    //Método para eliminar una postulacion por su codigo
    public void deletePostulacion(Long codigo) {
        Postulacion postulacion = postulacionRepository.findById(codigo)
            .orElseThrow(() -> new ResourceNotFoundException("Postulacion no encontrada"));
        postulacionRepository.delete(postulacion);
    }

    public Postulacion getPostulacionById(Long codigo) {
        return postulacionRepository.findById(codigo)
            .orElseThrow(() -> new ResourceNotFoundException("Postulacion not found with id " + codigo));
    }

    //Metodos generados automaticamente
    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public void deleteAllInBatch(Iterable<Postulacion> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public <S extends Postulacion> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Postulacion> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("Unimplemented method 'flush'");
    }

    @Override
    public Postulacion getById(Long arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Postulacion getOne(Long arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @Override
    public Postulacion getReferenceById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
    }

    @Override
    public <S extends Postulacion> List<S> saveAllAndFlush(Iterable<S> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @Override
    public <S extends Postulacion> S saveAndFlush(S entity) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }

    @Override
    public List<Postulacion> findAllById(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @Override
    public <S extends Postulacion> List<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void delete(Postulacion entity) {
        postulacionRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAll(Iterable<? extends Postulacion> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public Page<Postulacion> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Postulacion> long count(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <S extends Postulacion> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public <S extends Postulacion> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Postulacion, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }

    @Override
    public <S extends Postulacion> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }
    @Override
    public List<Postulacion> findAll(Sort sort) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public <S extends Postulacion> S save(S entity) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
