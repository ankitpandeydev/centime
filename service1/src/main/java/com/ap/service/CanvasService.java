package com.ap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.entity.Canvas;
import com.ap.exception.CustomException;
import com.ap.model.CanvasPojo;
import com.ap.model.SubCan;
import com.ap.repository.CanvasRepository;

@Service
public class CanvasService {

	@Autowired
	private CanvasRepository canvasRepository;

	public List<Canvas> findAll() {
		Iterable<Canvas> it = canvasRepository.findAll();
		List<Canvas> list = StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList());
		return list;
	}

	public Canvas findById(Long id) throws CustomException {

		Optional<Canvas> option = canvasRepository.findById(id);
		if (!option.isPresent()) {
			throw new CustomException("Record not found with id : " + id);
		}

		return option.get();
	}

	public List<CanvasPojo> getNestResponse() {

		Iterable<Canvas> it = canvasRepository.findAll();
		List<Canvas> list = StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList());
		List<CanvasPojo> result = new ArrayList<CanvasPojo>();
		for (Canvas can : list) {
			CanvasPojo canvasPojo = getCanvasPojo(can, list);
			if (canvasPojo != null) {
				result.add(canvasPojo);
			}
		}

		return result;
	}

	private CanvasPojo getCanvasPojo(Canvas can, List<Canvas> list) {
		List<SubCan> subCanList = list.stream().filter(x -> (can.getId() == x.getParentId()))
				.map(x -> new SubCan(x.getName())).collect(Collectors.toList());
		if (subCanList.size() == 0) {
			return null;
		}
		return new CanvasPojo(can.getName(), subCanList);

	}

}
