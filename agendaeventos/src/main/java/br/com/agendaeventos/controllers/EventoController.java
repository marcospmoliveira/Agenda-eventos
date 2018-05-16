package br.com.agendaeventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.agendaeventos.models.Convidado;
import br.com.agendaeventos.models.Evento;
import br.com.agendaeventos.repository.ConvidadoRepository;
import br.com.agendaeventos.repository.EventoRepository;

@Controller
public class EventoController {
	@Autowired
	private EventoRepository er;

	@Autowired
	private ConvidadoRepository cr;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {
		er.save(evento);
		return "redirect:/cadastrarEvento";
	}

	@RequestMapping("/eventos")
	public ModelAndView listEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ModelAndView detailsEvento(@PathVariable("codigo") Long codigo) {
		Evento evento = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/detailsEvento");
		mv.addObject("evento", evento);
		return mv;
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	public String detailsEventoPost(@PathVariable("codigo") Long codigo, Convidado convidado) {
		Evento evento = er.findByCodigo(codigo);
		convidado.setEvento(evento);
		cr.save(convidado);
		return "redirect:/{codigo}";
	}
}
