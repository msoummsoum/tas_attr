package com.home.application.controller;

import com.home.application.config.ApplicationConfig;
import com.home.task.domain.object.Assignment;
import com.home.task.domain.object.Status;
import com.home.task.domain.usecase.GetAllAssignmentByStatus;
import com.home.task.infrastructure.InfraConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AssignmentController.class)
class AssignmentControllerTest {

    @MockBean
    private GetAllAssignmentByStatus getAllAssignmentByStatus;
    @Autowired
    private AssignmentController assignmentController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_get_all_assignments_by_status() throws Exception {
        //given
        var assignment = new Assignment(1L, "nom", "description", Status.IN_PROGRESS);
        var list = List.of(assignment);
        //when
        when(getAllAssignmentByStatus.execute(any())).thenReturn(list);
        //then
        mockMvc.perform(get("/assignments?status="+Status.IN_PROGRESS).contentType(MediaType.APPLICATION_JSON)
                        //.content(objectMapper.writeValueAsString(tutorial)))
                )
                .andExpect(status().isOk())
                .andDo(print());
    }
}