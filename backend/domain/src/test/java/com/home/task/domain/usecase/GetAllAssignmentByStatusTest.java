package com.home.task.domain.usecase;


import com.home.task.domain.object.Assignment;
import com.home.task.domain.object.Status;
import com.home.task.domain.port.AssignmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.home.task.domain.object.Status.PENDING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetAllAssignmentByStatusTest {

    @Mock
    private AssignmentRepository assignmentRepository;

    @InjectMocks
    private GetAllAssignmentByStatus getAllAssignmentByStatus;

    @Test
    public void should_get_all_assignment_by_status() {
        //given
        Assignment assignment1 = new Assignment(1L, "receptionner cv1", "receptionner un cv pour recrutement", PENDING);
        Assignment assignment2 = new Assignment(2L, "receptionner cv2", "receptionner un cv pour recrutement2", PENDING);
        List<Assignment> assignmentList = List.of(assignment1, assignment2);
        when(assignmentRepository.getAllByStatus(PENDING)).thenReturn(assignmentList);

        //when
        List<Assignment> response = getAllAssignmentByStatus.execute(PENDING);

        //then
        assertEquals(assignmentList, response);
    }
}
