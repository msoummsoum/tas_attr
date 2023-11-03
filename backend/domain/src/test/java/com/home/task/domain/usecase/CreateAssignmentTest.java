package com.home.task.domain.usecase;


import com.home.task.domain.exception.InvalidDataAssignmentException;
import com.home.task.domain.object.Assignment;
import com.home.task.domain.object.Status;
import com.home.task.domain.port.AssignmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.home.task.domain.usecase.CreateAssignment.ERROR_MESSAGE_INVALID_DATA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateAssignmentTest {

    @Mock
    private AssignmentRepository assignmentRepository;

    @InjectMocks
    private CreateAssignment createAssignment;

    @Test
    public void should_create_assignment() {
        //given
        Assignment assignment = new Assignment(null, "receptionner cv", "receptionner un cv pour recrutement", Status.PENDING);
        Assignment assignmentAdded = new Assignment(1L, "receptionner cv", "receptionner un cv pour recrutement", Status.PENDING);
        when(assignmentRepository.add(assignment)).thenReturn(assignmentAdded);

        //when
        Assignment assignmentResponse = createAssignment.execute(assignment);

        //then
        assertEquals(assignmentResponse, assignmentAdded);
    }

    @Test
    public void should_not_create_asignment_if_invalid_name() {
        //given
        Assignment assignment = new Assignment(null, "r", "receptionner un cv pour recrutement", Status.ABANDONED);

        //when //then
        InvalidDataAssignmentException exception = assertThrows(InvalidDataAssignmentException.class, () -> {
            createAssignment.execute(assignment);
        });
        assertEquals(ERROR_MESSAGE_INVALID_DATA, exception.getMessage());
    }

    @Test
    public void should_not_create_asignment_if_invalid_status() {
        //given
        Assignment assignment = new Assignment(null, "rien", "receptionner un cv pour recrutement", null);

        //when //then
        InvalidDataAssignmentException exception = assertThrows(InvalidDataAssignmentException.class, () -> {
            createAssignment.execute(assignment);
        });
        assertEquals(ERROR_MESSAGE_INVALID_DATA, exception.getMessage());
    }
}
