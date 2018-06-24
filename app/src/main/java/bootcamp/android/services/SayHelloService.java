package bootcamp.android.services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class SayHelloService extends JobService{
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.i("bootcamp-job", "hello from Android workshop: ");
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.i("bootcamp-job", "bye from Android bootcamp ");
        return true;
    }
}
