package edu.spring.mvc.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.spring.mvc.project.domain.entity.Categoria;
import edu.spring.mvc.project.domain.entity.Estudio;
import edu.spring.mvc.project.domain.entity.VideoJuego;
import edu.spring.mvc.project.repositories.CategoriaRepository;
import edu.spring.mvc.project.repositories.EstudioRepository;
import edu.spring.mvc.project.repositories.VideoJuegoRepository;
import edu.spring.mvc.project.utils.Printer;

@Component
public class AppPruebas implements CommandLineRunner {

    @Autowired
    private CategoriaRepository cateRepo;
    @Autowired
    private EstudioRepository estuRepo;
    @Autowired
    private VideoJuegoRepository videRepo;

    @Override
    public void run(String... args) throws Exception {
        cateRepo.findAll().forEach(categoria -> System.out.println(
                categoria.getNombre() + " " + categoria.getNombre()
                ));
        estuRepo.findAll().forEach(categoria -> System.out.println(
                categoria.getNombre() + " " + categoria.getNombre()
                ));
        videRepo.findAll().forEach(categoria -> System.out.println(
                categoria.getId_videoJuego() + " " + categoria.getTitulo()
                ));
    }

    private void insertData() {
        var r1 = entityCategoria();
        var r2 = entityEstudio();
        entityVideoJuego(r1, r2);
    }

    private void entityVideoJuego(Categoria r1, Estudio r2) {
        var game = new VideoJuego();
        game.setTitulo("La biblia de linux");
        game.setPrecio(5.0F);
        game.setCantidad(1);
        game.setDescripcion("Mas alla de windows");
        game.setOferta(false);
        game.setCategoria(r1);
        game.setEstudio(r2);
        game.setEstado(1);
        var r3 = videRepo.save(game);
        System.out.println(r3.toString());
        videRepo.findAll().forEach(Printer::videoJuego);
    }

    private Estudio entityEstudio() {
        var estu = new Estudio();
        estu.setNombre("Ciencia");
        estu.setEstado(1);
        var r2 = estuRepo.save(estu);
        // System.out.println(r2.toString());
        estuRepo.findAll().forEach(item -> System.out.println(item.getId_estudio() + item.getNombre()));
        return r2;
    }

    private Categoria entityCategoria() {
        var cate = new Categoria();
        cate.setNombre("God");
        cate.setEstado(1);
        var r1 = cateRepo.save(cate);
        // System.out.println(r1.toString());

        cateRepo.findAll().forEach(item -> System.out.println(item.getId_categoria() + item.getNombre()));
        return r1;
    }

}
